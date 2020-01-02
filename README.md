**UI Assignment for SDET**

**Author**: Mikhail Miroshnichenko
**Email**: hikari.no.mikem@gmail.com

**Requirements:**
- JDK
- Maven
- Appium
- Allure (http://allure.qatools.ru/) (optionally, just to build report after test run)
- Lombok plugin for IDE (optionally, to correctly display few commands)
- Phone with active sim card, that was not used before
- Real email address, that was not used before

Was developed in IntelliJ Idea with Appium Desktop

**Test scenario**
1. Install release app from GPlay
2. Launch
3. Enter phone number (real, not used before)
4. Get verification code from sms and type in into application
5. Enter email (existed one, not used before)
6. Confirm using geo-location services
7. Confirm usage terms
8. Skip onboarding popup
9. Open menu
10. Open Rules section
11. Confirm terms
12. Return to home screen
13. Open menu
14. Select Profile
15. Log out

**How to run test:**

`mvn -Dphone="12345678" -Demail="my@email.com" test`

In this case it will require Appium server running in background. If you want test to launch Appium automatically,
then add "-Dappium" key to command line

**To view HTML report:**

`mvn allure:serve`

 This will launch web-server with interactive report
 
 **Cloud testing**
 
 Framework allows running on BrowserStack cloud platform. But you will have to provide valid credentials.
 It works not stable, need more time to stabilise. So think about this code just as example, how framework
 can be extended =)

**Disclaimer:**

The biggest difficulty in this test is verification flow.
1. User must use real phone to get verification code
2. SMS with verification code is sent to device, but not imported automatically into application
3. Country code probably is set by SIM card, not by location
4. User must use real email address
5. Email address can be used only once
6. If user already provided email address and confirmed usage terms, that these pages will not be shown on Onboarding.
7. There is 10 code per 24hours limit.

My ideas about solving this problems.

1. There are services, that provide you several real phone numbers, and you can get sms on it (like https://smsreceivefree.com/)
But to get sms you should use their web-sites, and it is not reliable (sometimes messages are not displayed on site).
Although I used it during development, this is not good idea to use it on regular basis: there are few available numbers,
so while running test with Auth flow regularly, numbers will be blocked. And, of course, UI steps are not reliable.

2. When code is sent to device, it should be displayed in Android notification panel. So I get it from notification panel.
This is not very good solution: there can be different launchers, and notification locators can be changed. I have tested
on Samsung phone with Google Messages app.

3. Obviously, test should set country code from UI. Because I can not change it by setting different location with Appium,
the only way is to interact with UI elements. It is not very difficult to scroll through countries and select needed one.
I need more time ot develop this functions. But there is no time left...

Solution for 1-3.

Ideally these test steps should be done by APi or back-end calls. For example, I can send some call to back-end with phone
number, and get answer with expected verification code. This way is stable (because we dont use any third-party web-sites
or services) and it can test any combination of country code/phone.

4-5. During development I used service for virtual email address (https://temp-mail.org/en/). On one side, it is possible
to create email there before test through web-interface. But, on other side, it is not reliable, not stable and will 
require more time to development.
Ideally, there should be option to delete user from database with single API call. In this case, before test, I can
execute command, that will remove real email from system database, and then use this email egain.

6-7 Can be fixed by aforementioned solutions.  

So, in breaf, to make this test perfect, I have to add:
- API call to get verification code for used phone (then using real phone will not be mandatory at all)
- API call to delete user before test (so I can create single real email, and use it any time)
In this case flow will be stable, reliable and fast.

