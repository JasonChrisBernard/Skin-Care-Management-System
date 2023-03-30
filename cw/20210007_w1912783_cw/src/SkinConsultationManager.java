import java.io.IOException;
import java.util.ArrayList;

public interface SkinConsultationManager {
    void doc_details();
    void add_doc();

    void delete_doc();

    ArrayList<Doctor> list_of_doctors() throws IOException;

    void save_file() throws IOException;

    void gui();


}
