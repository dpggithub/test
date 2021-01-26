package service;

public class LinuxServiceImpl implements ListService{
    @Override
    public String showListCmd(){
        return "ls";
    }
}
