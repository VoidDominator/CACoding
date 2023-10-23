package interface_adapter.clear_users;

// TODO Complete me

import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;
import interface_adapter.ViewManagerModel;
import javax.swing.*;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ClearViewModel clearViewModel, ViewManagerModel viewManagerModel) {
        this.clearViewModel = clearViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(ClearOutputData clearOutputData) {
        ClearState clearState = clearViewModel.getState();
        clearViewModel.setState(clearState);
        clearViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(clearViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
//        System.out.println("Successfully cleared all users.");

        //swing popup with message "Successfully cleared all users."
//        JOptionPane.showMessageDialog(null, "Successfully cleared all users.");
        String displayStr = "";
        for (String x:clearOutputData.usernames) {
            displayStr += x+"\n";
        }
        clearViewModel.setClearedUsers(displayStr);
//        JOptionPane.showMessageDialog(null, displayStr);
    }

    @Override
    public void prepareFailView(String error) {

    }
}
