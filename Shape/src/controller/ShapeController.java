/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ShapeDTO;
import java.util.ArrayList;
import java.util.List;
import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;
import view.ShapeView;

public class ShapeController {

    private ShapeView shapeView;
    private List<Shape> shapeList;
    private ShapeDTO shapeDTO;

    //Khoi tao view, dto va mang quan ly cac hinh
    public ShapeController() {
        shapeView = new ShapeView();
        shapeList = new ArrayList<Shape>();
        shapeDTO = new ShapeDTO();
    }

    //Setter dto

    public void setShapeDTO(ShapeDTO shapeDTO) {
        this.shapeDTO = shapeDTO;
    }
    

    //Tao cac doi tuong hinh va them vao list de luu tru
    public void createShape() {
        Shape rectangle = new Rectangle(shapeDTO.getWidth(), shapeDTO.getLength());
        Shape circle = new Circle(shapeDTO.getRadius());
        Shape triangle = new Triangle(shapeDTO.getSideA(), shapeDTO.getSideB(), shapeDTO.getSideC());
        shapeList.add(rectangle);
        shapeList.add(circle);
        shapeList.add(triangle);
        showList(shapeList);
    }

    //Kiem tra cac hinh va them vao danh sach
    public void showList(List<Shape> shapeList) {
        //Duyet qua danh sach cac hinh
        for (Shape shape : shapeList) {
            if (shape instanceof Rectangle) {
                //Ep kieu va chuyen thong tin Rectangle cho view
                shapeView.setRectangleInfo(((Rectangle) shape).toString());
            } else if (shape instanceof Circle) {
                //Ep kieu va chuyen thong tin Circle cho view
                shapeView.setCircleInfo(((Circle) shape).toString());

            } else if (shape instanceof Triangle) {
                //Ep kieu va chuyen thong tin Circle cho view
                shapeView.setTriangleInfo(((Triangle) shape).toString());
            }
        }
        //Hien thi ket qua
        shapeView.printResult();
    }

}
