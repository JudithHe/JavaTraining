@Service
public class CSVService {

    @Autowired
    private YourEntityRepository repository;

    public void readCSVAndSaveToDB(String fileName) {
        // Get the file from the resources folder
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                YourEntity entity = new YourEntity();
                entity.setColumn1(csvRecord.get("ColumnName1"));
                entity.setColumn2(csvRecord.get("ColumnName2"));
                // ... populate the entity with the CSV data ...

                repository.save(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse CSV file " + e.getMessage());
        }
    }
}
