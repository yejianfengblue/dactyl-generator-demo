 
    difference () {
 
          translate ([0, 0, 2.65]) {
            union () {
              color("springgreen", 0.5)
              cylinder (h=5.3, r1=4.255, r2=4.15, center=true);
              translate ([0, 0, 2.65]) {
                sphere (r=4.15);
              }
            }
          }

 
 
        translate ([0, 0, 1.89]) {
          union () {
            
            cylinder (h=3.8, r1=2.655, r2=2.55, center=true);
            translate ([0, 0, 1.9]) {
              sphere (r=2.55);
            }
          }
        }
 

    }
 
