package codegym.repository;

import codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    List<Book> findByNameContains(String name);
    List<Book> findByPriceGreaterThanAndAuthorContains(long price, String author);

//    @Query("Select b from Book b where b.price > :price and b.author like :author")
    @Query(nativeQuery = true, value = "Select * from Book where price > :price and author like :author")
    List<Book> findPriceAndAuthor(@Param("price") long price,@Param("author") String author);
}
