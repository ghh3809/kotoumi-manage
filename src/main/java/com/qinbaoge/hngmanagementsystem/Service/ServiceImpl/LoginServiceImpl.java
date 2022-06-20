package com.qinbaoge.hngmanagementsystem.Service.ServiceImpl;
import com.qinbaoge.hngmanagementsystem.Entity.Username;
import com.qinbaoge.hngmanagementsystem.Mapper.LoginMapper;
import com.qinbaoge.hngmanagementsystem.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Username find_this_username(String username) {
        return loginMapper.find_this_username(username);
    }
}
