package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:real.properties"
})
public interface RealMobileMobileConfig extends Config {

    String deviceName();

    String mobileUrl();

    String appPackage();

    String appActivity();
    String appLanguage();
    String appLocale();

}
