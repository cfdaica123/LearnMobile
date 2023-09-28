package son.dev.foodapp.constract;

public interface RegisterConstract {
    interface IView{
        void registrationFailed();
        void registrationSuccess();
    }
    interface IPresenter{
        void doRegistration(String email, String password);
    }
}
