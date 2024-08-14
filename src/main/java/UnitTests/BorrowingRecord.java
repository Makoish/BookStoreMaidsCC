//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class BorrowingRecordRepositoryTests {
//
//    @Autowired
//    private BorrowingRecordRepository borrowingRecordRepository;
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private PatronRepository patronRepository;
//
//    @Test
//    public void testSaveBorrowingRecord() {
//        Book book = new Book("Moby Dick", "Herman Melville");
//        Patron patron = new Patron("Alice Johnson", "alicej@example.com");
//
//        Book savedBook = bookRepository.save(book);
//        Patron savedPatron = patronRepository.save(patron);
//
//        BorrowingRecord record = new BorrowingRecord(savedPatron.getId(), savedBook.getId());
//        BorrowingRecord savedRecord = borrowingRecordRepository.save(record);
//
//        assertNotNull(savedRecord.getId());
//        assertEquals(savedPatron.getId(), savedRecord.getPatron());
//        assertEquals(savedBook.getId(), savedRecord.getBook());
//    }
//
//    @Test
//    public void testFindBorrowingRecordById() {
//        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
//        Patron patron = new Patron("Bob White", "bobw@example.com");
//
//        Book savedBook = bookRepository.save(book);
//        Patron savedPatron = patronRepository.save(patron);
//
//        BorrowingRecord record = new BorrowingRecord(savedPatron.getId(), savedBook.getId());
//        BorrowingRecord savedRecord = borrowingRecordRepository.save(record);
//
//        Optional<BorrowingRecord> foundRecord = borrowingRecordRepository.findById(savedRecord.getId());
//        assertTrue(foundRecord.isPresent());
//        assertEquals(savedPatron.getId(), foundRecord.get().getPatron());
//        assertEquals(savedBook.getId(), foundRecord.get().getBook());
//    }
//
//    @Test
//    public void testUpdateBorrowingRecord() {
//        Book book = new Book("War and Peace", "Leo Tolstoy");
//        Patron patron = new Patron("Clara Knight", "claran@example.com");
//
//        Book savedBook = bookRepository.save(book);
//        Patron savedPatron = patronRepository.save(patron);
//
//        BorrowingRecord record = new BorrowingRecord(savedPatron.getId(), savedBook.getId());
//        BorrowingRecord savedRecord = borrowingRecordRepository.save(record);
//
//        // Update the record
//        savedRecord.setReturnDate(LocalDate.now());
//        BorrowingRecord updatedRecord = borrowingRecordRepository.save(savedRecord);
//
//        assertEquals(LocalDate.now(), updatedRecord.getReturnDate());
//    }
//}
