package Persistence.DataAccessors;

import Exceptions.FileManagerException;
import Models.User.Employee;
import Persistence.Mappers.EmployeeMapper;
import Settings.FileSettings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class EmployeesDataAccessor extends DataAccessor<Employee,Integer> {
    public static File entriesDirectory = FileSettings.employeesDirectory;;
    public EmployeesDataAccessor() throws FileManagerException {
        super();

        if(!entriesDirectory.exists() && !entriesDirectory.mkdirs()) throw new FileManagerException("creating model directory "+ entriesDirectory.getName() + " was unsuccessful");

    }

    @Override
    public void add(Employee employee) throws FileManagerException, IOException {
        File entryFile = new File(entriesDirectory + "/" + employee.id +".employee");
        if(!entryFile.exists()) {
            if(!entryFile.createNewFile()) throw new FileManagerException("could not create");
        }
        else throw new FileManagerException("already exists");

        try (FileWriter fileWriter = new FileWriter(entryFile)) {
            EmployeeMapper.map(employee,fileWriter);
            fileWriter.flush();
        }
    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public Employee load(Integer integer) throws FileNotFoundException {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public <T> boolean any(Predicate<T> predicate) {
        return false;
    }

    @Override
    public <T> List<Employee> where(Predicate<T> predicate) {
        return null;
    }

    @Override
    public List<Integer> AllExistingKeys() {
        List<Integer> keys = new LinkedList<>();
        for (File entry : Objects.requireNonNull(entriesDirectory.listFiles(File::isFile))){
            keys.add(Integer.parseInt(entry.getName().split("\\.")[0]));
        }
        return keys;
    }
}
