import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeType{

    private String name;
    private String color;
    private String texture;

    public TreeType(String name,String color,String texture){
   
        this.name = name;
        this.color= color;
        this.texture = texture;
    }
    public void draw(int x,int y){
        System.out.println("Drawing tree at (" + x + "," +y+ ") with type "+ name);
    }
}

class Tree{
    private int x;
    private int y;
    private TreeType treeType;

    public Tree(int x,int y,TreeType treeType){
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw(){
        treeType.draw(x,y);
    }

}
class TreeFactory{
    static Map<String ,TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String name,String color,String texture){
        String key = name +"-" + color + "-" + texture;
       if(!treeTypeMap.containsKey(key)) treeTypeMap.put(key,new TreeType(name, color, texture));
        return treeTypeMap.get(key);
    }
}





class Forest{
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x,int y,String name,String color,String texture){
        // TreeType treeType = new TreeType(name, color, texture);
        Tree tree = new Tree(x,y,TreeFactory.getTreeType(name, color, texture));
        trees.add(tree);

    }
    public void draw(){
        for(Tree tree : trees){
            tree.draw();
        }
    }
}
public class Flyweight{
    public static void main(String[] args) {
        Forest forest = new Forest();
        for(int i = 0;i<1000;i++){
            forest.plantTree(i,i,"Oak","Green","Rought");
        }

        forest.draw();
    }
}