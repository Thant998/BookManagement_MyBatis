package bookspringmybatis.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import bookspringmybatis.dto.BookRequestDTO;
import bookspringmybatis.dto.BookResponseDTO;
public interface BookMapper {
	String insert="insert into book(book_code,book_title,book_author,book_price)"
			+ "values(#{bookCode},#{bookTitle},#{bookAuthor},#{bookPrice})";
	String update="update book set book_title=#{bookTitle}, book_author=#{bookAuthor},book_price=#{bookPrice}"
			+ "where book_code=#{bookCode}";
	String delete= "delete from book where book_code=#{bookCode}";
	String selectAll="select * from book";
	String selectOne="select * from book where book_code=#{bookCode}";
	
	@Insert(insert)
	int insert(BookRequestDTO dto);
	
	@Update(update)
	int update (BookRequestDTO dto);
	
	@Delete(delete)
	int delete(BookRequestDTO dto);
	
	@Select(selectAll)
	@Results(value ={
		@Result(column ="book_code", property="bookCode"),
		@Result(column ="book_title", property="bookTitle"),
		@Result(column ="book_author", property="bookAuthor"),
		@Result(column ="book_price", property="bookPrice")
	})
	ArrayList<BookResponseDTO> selectAll();
	
	@Select(selectOne)
	@Results(value = {
			@Result(column ="book_code", property="bookCode"),
			@Result(column ="book_title", property="bookTitle"),
			@Result(column ="book_author", property="bookAuthor"),
			@Result(column ="book_price", property="bookPrice")
	})
	BookResponseDTO selectOne(BookRequestDTO dto);

			
}
