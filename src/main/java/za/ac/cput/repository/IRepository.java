package za.ac.cput.repository;
@Deprecated
public interface IRepository <R, ID>{
    R create(R r);
    R read(ID id);
    R update(R r);
    boolean delete(ID id);
}





