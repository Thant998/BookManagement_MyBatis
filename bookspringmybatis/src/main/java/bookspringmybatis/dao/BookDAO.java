package bookspringmybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookspringmybatis.mapper.BookMapper;
import bookspringmybatis.dto.BookRequestDTO;
import bookspringmybatis.dto.BookResponseDTO;
@Service("bookService")
public class BookDAO {
@Autowired
BookMapper bookMapper;
public int insert(BookRequestDTO dto) {
	// TODO Auto-generated method stub
	return bookMapper.insert(dto);
}
public int update(BookRequestDTO dto) {
	// TODO Auto-generated method stub
	return bookMapper.update(dto);
}
public int delete(BookRequestDTO dto) {
	// TODO Auto-generated method stub
	return bookMapper.delete(dto);
}
public List<BookResponseDTO> selectAll() {
	// TODO Auto-generated method stub
	System.out.print(bookMapper.selectAll());
	return bookMapper.selectAll();
}


public BookResponseDTO selectOne(BookRequestDTO dto) {
	// TODO Auto-generated method stub
	return bookMapper.selectOne(dto);
}
	
	
	

}
