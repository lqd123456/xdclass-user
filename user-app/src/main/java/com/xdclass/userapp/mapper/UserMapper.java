package com.xdclass.userapp.mapper;

import com.xdclass.userapp.model.User;
import com.xdclass.userapp.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_user (account, address, ",
        "password, phone, point, ",
        "remark, tel_phone, username, ",
        "zip_code, balance)",
        "values (#{account,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{phone,jdbcType=CHAR}, #{point,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{telPhone,jdbcType=CHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{zipCode,jdbcType=VARCHAR}, #{balance,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="point", property="point", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel_phone", property="telPhone", jdbcType=JdbcType.CHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="zip_code", property="zipCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.BIGINT)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, account, address, password, phone, point, remark, tel_phone, username, zip_code, ",
        "balance",
        "from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="point", property="point", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel_phone", property="telPhone", jdbcType=JdbcType.CHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="zip_code", property="zipCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.BIGINT)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update t_user",
        "set account = #{account,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=CHAR},",
          "point = #{point,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "tel_phone = #{telPhone,jdbcType=CHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "zip_code = #{zipCode,jdbcType=VARCHAR},",
          "balance = #{balance,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}