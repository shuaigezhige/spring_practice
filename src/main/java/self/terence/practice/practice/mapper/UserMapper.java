package self.terence.practice.practice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import self.terence.practice.practice.model.User;

@Mapper
public interface UserMapper {

    @Insert("insert into public.user(id, account_id, name, token, gmt_create, gmt_modified) values (#{id},#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);

}