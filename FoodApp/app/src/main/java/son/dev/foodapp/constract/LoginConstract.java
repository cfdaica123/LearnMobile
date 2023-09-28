package son.dev.foodapp.constract;

public interface LoginConstract {
    interface IView{
        void loginFailed();
        void loginSuccess();
    }
    interface IPresenter{
        void doLogin(String email, String password);
    }
}
