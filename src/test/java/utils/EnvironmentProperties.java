package utils;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.Classpath("environment.properties")
public class EnvironmentProperties {

    public EnvironmentProperties() {
        PropertyLoader.populate(this);
    }

    @Property("BSuserName")
    private String BSpropUserName;

    @Property("BSuserPsw")
    private String BSpropUserPsw;

    @Property("BSserver")
    private String BSserver;

    @Property("SLuserName")
    private String SLpropUserName;

    @Property("SLuserPsw")
    private String SLpropUserPsw;

    public String getBrowserStackUserName() {
        return BSpropUserName;
    }

    public String getBrowserStackUserPsw() {
        return BSpropUserPsw;
    }

    public String getBSserver() {
        return BSserver;
    }

    public String getSauceLabsUserName() {
        return SLpropUserName;
    }

    public String getSauceLabsUserPsw() {
        return SLpropUserPsw;
    }
}