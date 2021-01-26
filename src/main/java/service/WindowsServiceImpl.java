package service;

public class WindowsServiceImpl implements ListService {
    @Override
    public String showListCmd(){
        return "dir";
    }
}
