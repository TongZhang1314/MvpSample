package mvpsample.tongzhang.com.mvpsample.core.prefs;

public interface PreferenceHelper {

    void setLoginAccount(String account);

    void setLoginPassword(String password);

    String getLoginAccount();

    String getLoginPassword();
}
