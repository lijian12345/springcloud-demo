package cn.jian.user.api;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.jian.user.dto.UserDto;
import cn.jian.user.entity.User;
import cn.jian.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(value = "UserEndpoint", description = "用户管理相关Api")
public class UserEndpoint {
    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping
    @ApiOperation(value = "获取用户分页数据", notes = "获取用户分页数据", httpMethod = "GET", tags = "用户管理相关Api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页，从0开始，默认为第0页", dataType = "int",
                    paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每一页记录数的大小，默认为20", dataType = "int",
                    paramType = "query"),
            @ApiImplicitParam(name = "sort",
                    value = "排序，格式为:property,property(,ASC|DESC)的方式组织，如sort=firstname&sort=lastname,desc",
                    dataType = "String", paramType = "query")})
    public List<UserDto> findAll(Pageable pageable) {
        Page<User> page = this.userService.getPage(pageable);
        if (null != page) {
            return page.getContent().stream().map((user) -> {
                return new UserDto(user);
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户详情数据", notes = "获取用户详情数据", httpMethod = "GET", tags = "用户管理相关Api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户的主键", dataType = "int", paramType = "path")})
    public UserDto detail(@PathVariable Long id) {
        User user = this.userService.load(id);
        return (null != user) ? new UserDto(user) : null;
    }

    /**
     * 更新用户详情
     * @param id
     * @return
     */
    @PostMapping("/{id}")
    @ApiOperation(value = "更新用户详情数据", notes = "更新用户详情数据", httpMethod = "POST", tags = "用户管理相关Api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户的主键", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userDto", value = "用户详情数据", dataType = "UserDto",
                    paramType = "body"),})
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        User user = this.userService.save(userDto);
        return (null != user) ? new UserDto(user) : null;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除指定用户", notes = "删除指定用户", httpMethod = "DELETE", tags = "用户管理相关Api")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "所要删除用户的主键", dataType = "int",
            paramType = "path")})
    public boolean delete(@PathVariable Long id) {
        this.userService.delete(id);
        return true;
    }
}
