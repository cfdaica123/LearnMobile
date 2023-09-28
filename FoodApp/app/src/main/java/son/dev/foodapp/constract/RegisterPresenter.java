package son.dev.foodapp.constract;

public class RegisterPresenter implements RegisterConstract.IPresenter{
    private RegisterConstract.IView mView;

    public RegisterPresenter(RegisterConstract.IView view){
        mView = view;
    }


    @Override
    public void doRegistration(String email, String password) {
        if (!email.isEmpty() && !password.isEmpty()) {



            mView.registrationSuccess();
        } else {
            mView.registrationFailed();
        }
    }
}
