package mydomain.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
@Index(name = "dummy_index_multiple_1", members = {"stringProp1"}, extensions = {
        @Extension(vendorName="datanucleus", key="index-type", value="HASH")
})
@Index(name = "dummy_index_multiple_2", members = {"stringProp2"}, extensions = {
        @Extension(vendorName="datanucleus", key="index-type", value="HASH")
})
public class DummyWithTwoIndices {
    @PrimaryKey
    public Long id;

    public String stringProp1;

    public String stringProp2;
}
