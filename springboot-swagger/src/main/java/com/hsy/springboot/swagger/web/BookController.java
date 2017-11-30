package com.hsy.springboot.swagger.web;

import com.hsy.springboot.swagger.bean.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 *
     Api：修饰整个类，描述Controller的作用
     ApiOperation：描述一个类的一个方法，或者说一个接口
     ApiParam：单个参数描述
     ApiModel：用对象来接收参数
     ApiProperty：用对象接收参数时，描述对象的一个字段
     ApiResponse：HTTP响应其中1个描述
     ApiResponses：HTTP响应整体描述
     ApiIgnore：使用该注解忽略这个API
     ApiError ：发生错误返回的信息
     ApiParamImplicitL：一个请求参数
     ApiParamsImplicit 多个请求参数

 */
@Api(value = "书籍接口",description = "书籍相关的处理")
@RestController
@RequestMapping("/api/books")
public class BookController {

    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value="获取图书列表", notes="获取图书列表")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<Book> getBook() {
        List<Book> book = new ArrayList<>(books.values());
        return book;
    }

    @ApiOperation(value="创建图书", notes="创建图书")
    @ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        books.put(book.getId(), book);
        return "success";
    }
    @ApiOperation(value="获图书细信息", notes="根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return books.get(id);
    }

    @ApiOperation(value="更新信息", notes="根据url的id来指定更新图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody Book book) {
        Book book1 = books.get(id);
        book1.setName(book.getName());
        book1.setPrice(book.getPrice());
        books.put(id, book1);
        return "success";
    }
    @ApiOperation(value="删除图书", notes="根据url的id来指定删除图书")
    @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        books.remove(id);
        return "success";
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }

}
