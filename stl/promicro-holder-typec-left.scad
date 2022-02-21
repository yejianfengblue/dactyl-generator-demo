difference() {
import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);

translate([00, 45, 0])
cube([40, 10, 50]);
  
  translate([27.3, 18, 19.5])
  cube([9.5, 10, 4], center = true);
}

translate([00,2,0])
difference() {
import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);

translate([00, 0, 0])
cube([40, 42.9, 50]);
}

*translate([40,0,0])
difference() {
import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);


}

*color("red")
translate([35, 50.7, 0])
cube([30, 2, 50]);