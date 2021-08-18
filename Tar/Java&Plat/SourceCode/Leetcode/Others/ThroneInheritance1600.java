import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;


class ThroneInheritance {
    private Map<String, List<String>> inheritance_map;
    private Set<String> death_set;
    private String starting_king;
    public ThroneInheritance(String kingName) {
        starting_king = kingName;
        inheritance_map = new HashMap();
        death_set = new HashSet();
        inheritance_map.put(kingName, new ArrayList());
    }

    public void birth(String parentName, String childName) {
        inheritance_map.get(parentName).add(childName);
        inheritance_map.put(childName, new ArrayList());
    }

    public void death(String name) {
        death_set.add(name);
    }

    public List<String> getInheritanceOrder() {
        String current = starting_king;
        List<String> result = new ArrayList();
        helper(current, result);
        return result;
    }

    public void helper(String current, List<String> result) {
        if (!death_set.contains(current))
            result.add(current);
        List<String> children = inheritance_map.get(current);
        if (children.size() != 0) {
            for (String child : children) {
                helper(child, result);
            }
        }
    }
}
