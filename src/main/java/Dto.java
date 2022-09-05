import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dto {
    //부서부분

    private String name;                    //부서 기본명
    private String deptExternalKey;         //부서 외부키
    private String parentDeptExternalKey;   //상위 부서 외부키(최상위 조직일 경우만 #)
    private String dispOrd;                 //조직도 부서 노출 순서

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }



}
