package son.dev.foodapp.constract;

public class LoginPresenter implements LoginConstract.IPresenter{
    private LoginConstract.IView mView;

    public LoginPresenter(LoginConstract.IView view){
        mView = view;
    }
    @Override
    public void doLogin(String email, String password) {
        if(email.equals("admin") && password.equals("123")){
            mView.loginSuccess();
        }else{
            mView.loginFailed();
        }
    }
}
