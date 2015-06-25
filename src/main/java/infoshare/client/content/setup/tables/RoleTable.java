package infoshare.client.content.setup.tables;

import com.vaadin.ui.Table;
import infoshare.client.content.MainLayout;
import infoshare.client.content.setup.models.RoleModel;
import infoshare.domain.Role;
import infoshare.services.roles.Impl.RoleServiceImpl;
import infoshare.services.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/06/24.
 */
public class RoleTable extends Table {

    private final MainLayout main;
    @Autowired
    private RoleService roleService = new RoleServiceImpl();

    public RoleTable(MainLayout main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Role Name", String.class, null);
        addContainerProperty("Description", String.class, null);
        List<Role> roles = roleService.findAll();
        for (Role role : roles) {
            addItem(new Object[]{role.getRolename(),
                    role.getDescription()
            }, role.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
