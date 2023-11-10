package egenius.product.categorys.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Categorys {


    private String categoryName;

    private String parentCategory; // 카테고리 대분류

    private List<Categorys> childCategory;// 하위 카테고리들 (중분류)

    // 카테고리 등록 (대분류 등록)
    public static Categorys createParentCategory(String categoryName){
        return Categorys.builder()
                .categoryName(categoryName)
                .build();
    }

    //카테고리 등록 (중분류 등록)
    public static Categorys createChildCategory(String categoryName, String parentCategory){
        return Categorys.builder()
                .categoryName(categoryName)
                .parentCategory(parentCategory)
                .build();
    }

    //카테고리 조회 (대분류 카테고리 조회)
    public static Categorys readParentCategory(String categoryName, String parentCategory, List<String> childCategory){
        return Categorys.builder()
                .categoryName(categoryName)
                .parentCategory(parentCategory)
                .build();
    }

    //카테고리 조회 (중분류 카테고리 조회)
    public static Categorys readChildCategory(String categoryName, String parentCategory){
        return Categorys.builder()
                .categoryName(categoryName)
                .parentCategory(parentCategory)
                .build();
    }

    //todo : 카테고리 수정

    //todo : 카테고리 삭제
}
