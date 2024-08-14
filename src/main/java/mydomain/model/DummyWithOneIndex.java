package mydomain.model;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
@Index(name = "dummy_index_single", members = {"stringProp1"}, extensions = {
        @Extension(vendorName="datanucleus", key="index-type", value="HASH")
})
public class DummyWithOneIndex {
    @PrimaryKey
    public Long id;

    public String stringProp1;
}
