package self.terence.practice.practice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;
import self.terence.practice.practice.model.User;

@Component
public class UserMapperImpl implements  UserMapper{
    @Override
    @Insert("insert into user(id, account_id, name, token, gmt_create, gmt_modified) values (#{id},#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified})")
    public void insert(User user) {
    }
}
