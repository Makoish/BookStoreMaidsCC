//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class BookRepositoryTests {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Test
//    public void testSaveBook() {
//        Book book = new Book("The Catcher in the Rye", "J.D. Salinger");
//        Book savedBook = bookRepository.save(book);
//
//        assertNotNull(savedBook.getId());
//        assertEquals("The Catcher in the Rye", savedBook.getTitle());
//    }
//
//    @Test
//    public void testFindBookById() {
//        Book book = new Book("1984", "George Orwell");
//        Book savedBook = bookRepository.save(book);
//
//        Optional<Book> foundBook = bookRepository.findById(savedBook.getId());
//        assertTrue(foundBook.isPresent());
//        assertEquals("1984", foundBook.get().getTitle());
//    }
//
//    @Test
//    public void testDeleteBook() {
//        Book book = new Book("To Kill a Mockingbird", "Harper Lee");
//        Book savedBook = bookRepository.save(book);
//
//        bookRepository.deleteById(savedBook.getId());
//        Optional<Book> deletedBook = bookRepository.findById(savedBook.getId());
//        assertFalse(deletedBook.isPresent());
//    }
//}
