package use_case.clear_users;

// TODO Complete me

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface clearUserDataAccessObject;
    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface clearUserDataAccessInterface, ClearOutputBoundary clearOutputBoundary) {
        this.clearUserDataAccessObject = clearUserDataAccessInterface;
        this.clearPresenter = clearOutputBoundary;
    }
    @Override
    public void execute() {
        try{
            clearUserDataAccessObject.clear();
            clearPresenter.prepareSuccessView(new ClearOutputData());
        } catch (Exception e) {
            clearPresenter.prepareFailView(e.getMessage());
        }
    }
}
