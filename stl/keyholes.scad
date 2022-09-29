union() {
  
  // box and mx
  color("Green", 1) {
    translate ([ 0, 0, 0 ]) {
      union() {
        union() {
          translate([ 0, 7.825, 5 / 2 ]) {
            cube([ 17.3, 1.65, 5 ], center = true);
          }
          translate([ 7.825, 0, 5 / 2 ]) {
            cube([ 1.65, 17.3, 5 ], center = true);
          }
        }
        mirror([ 0, 1, 0 ]) {
          mirror([ 1, 0, 0 ]) {
            union() {
              translate([ 0, 7.825, 5 / 2 ]) {
                cube([ 17.3, 1.65, 5 ], center = true);
              }
              translate([ 7.825, 0, 5 / 2 ]) {
                cube([ 1.65, 17.3, 5 ], center = true);
              }
            }
          }
        }
      }
    }
  }

  // box and mx hotswap
  color("LightGreen", 1) {
    translate([ 17.3, 0, 0 ]) {
      union() {
        union() {
          translate([ 0, 7.825, 5 / 2 ]) {
            cube([ 17.3, 1.65, 5 ], center = true);
          }
          translate([ 7.825, 0, 5 / 2 ]) {
            cube([ 1.65, 17.3, 5 ], center = true);
          }
        }
        mirror([ 0, 1, 0 ]) {
          mirror([ 1, 0, 0 ]) {
            union() {
              translate([ 0, 7.825, 5 / 2 ]) {
                cube([ 17.3, 1.65, 5 ], center = true);
              }
              translate([ 7.825, 0, 5 / 2 ]) {
                cube([ 1.65, 17.3, 5 ], center = true);
              }
            }
          }
        }
        union() {
          difference() {
            translate([ 0, 4.25, -1.5 ]) {
              cube([ 17.0, 8.5, 3 ], center = true);
            }
            cylinder($fn = 12, h = 10, r = 2.0, center = true);
            union() {
              translate([ -3.81, 2.54, 0 ]) {
                cylinder($fn = 8, h = 10, r = 1.65, center = true);
              }
              translate([ 3.81, 2.54, 0 ]) {
                cylinder($fn = 8, h = 10, r = 1.65, center = true);
              }
            }
            union() {
              translate([ 2.54, 5.08, 0 ]) {
                cylinder($fn = 8, h = 10, r = 1.65, center = true);
              }
              translate([ -2.54, 5.08, 0 ]) {
                cylinder($fn = 8, h = 10, r = 1.65, center = true);
              }
            }
            translate([ -5, 0, 0 ]) {
              cylinder($fn = 8, h = 10, r = 0.85, center = true);
            }
            translate([ 5, 0, 0 ]) {
              cylinder($fn = 8, h = 10, r = 0.85, center = true);
            }
            translate([ 0, 5, -2.6 ]) {
              cube([ 19, 8.2, 3.5 ], center = true);
            }
          }
        }
      }
    }
  }
  
  
  // mx
  color("Blue", 1) {
    translate([ 0, -17.3, 0 ]) {
      union () {
        union () {
          translate ([0, 7.825, 5/2]) {
            cube ([17.3, 1.65, 5], center=true);
          }
          translate ([7.825, 0, 5/2]) {
            cube ([1.65, 17.3, 5], center=true);
          }
          hull () {
            translate ([7.75, 0, 5/2]) {
              cube ([1.5, 2.75, 5], center=true);
            }
            translate ([7.0, 0, 1]) {
              rotate (a=90.0, v=[1, 0, 0]) {
                cylinder ($fn=30, h=2.75, r=1, center=true);
              }
            }
          }
        }
        mirror ([0, 1, 0]) {
          mirror ([1, 0, 0]) {
            union () {
              translate ([0, 7.825, 5/2]) {
                cube ([17.3, 1.65, 5], center=true);
              }
              translate ([7.825, 0, 5/2]) {
                cube ([1.65, 17.3, 5], center=true);
              }
              hull () {
                translate ([7.75, 0, 5/2]) {
                  cube ([1.5, 2.75, 5], center=true);
                }
                translate ([7.0, 0, 1]) {
                  rotate (a=90.0, v=[1, 0, 0]) {
                    cylinder ($fn=30, h=2.75, r=1, center=true);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  // mx-snap-in
  color("Cyan", 1) {
    translate ([ 17.3, -17.3, 0 ]) {
      union() {
        union() {
          translate([ 0, 7.825, 5 / 2 ]) {
            cube([ 17.3, 1.65, 5 ], center = true);
          }
          translate([ 7.825, 0, 5 / 2 ]) {
            cube([ 1.65, 17.3, 5 ], center = true);
          }
          hull() {
            translate([ 7.75, 0, 2.875 ]) {
              cube([ 1.5, 2.75, 4.25 ], center = true);
            }
            translate([ 7.0, 0, 1.75 ]) {
              rotate(a = 90.0, v = [ 1, 0, 0 ]) {
                cylinder($fn = 30, h = 2.75, r = 1, center = true);
              }
            }
          }
        }
        mirror([ 0, 1, 0 ]) {
          mirror([ 1, 0, 0 ]) {
            union() {
              translate([ 0, 7.825, 5 / 2 ]) {
                cube([ 17.3, 1.65, 5 ], center = true);
              }
              translate([ 7.825, 0, 5 / 2 ]) {
                cube([ 1.65, 17.3, 5 ], center = true);
              }
              hull() {
                translate([ 7.75, 0, 2.875 ]) {
                  cube([ 1.5, 2.75, 4.25 ], center = true);
                }
                translate([ 7.0, 0, 1.75 ]) {
                  rotate(a = 90.0, v = [ 1, 0, 0 ]) {
                    cylinder($fn = 30, h = 2.75, r = 1, center = true);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
    
  
  // kailh
  color("Red", 1) {
    translate([ 0, -34.6, 0 ]) {
      union() {
        union() {
          difference() {
            translate([ 0, 7.825, 5 / 2 ]) {
              cube([ 17.3, 1.65, 5 ], center = true);
            }
            translate([ 0, 7.75, 1 / 5 ]) {
              cube([ 4.666666666666667, 1.6, 6.8 ], center = true);
            }
          }
          translate([ 7.825, 0, 5 / 2 ]) {
            cube([ 1.65, 17.3, 5 ], center = true);
          }
        }
        mirror([ 0, 1, 0 ]) {
          mirror([ 1, 0, 0 ]) {
            union() {
              difference() {
                translate([ 0, 7.825, 5 / 2 ]) {
                  cube([ 17.3, 1.65, 5 ], center = true);
                }
                translate([ 0, 7.75, 1 / 5 ]) {
                  cube([ 4.666666666666667, 1.6, 6.8 ], center = true);
                }
              }
              translate([ 7.825, 0, 5 / 2 ]) {
                cube([ 1.65, 17.3, 5 ], center = true);
              }
            }
          }
        }
      }
    }
  }


  // kailh choc
  color("Yellow", 1) {  
    translate([ 0, -51.9, -0.12 ]) {
      union() {
          union() {
            translate([ 0, 7.825, 3.5 ]) {
              cube([ 17.3, 1.65, 3.25 ], center = true);
            }
            translate([ 7.825, 0, 3.5 ]) {
              cube([ 1.65, 17.3, 3.25 ], center = true);
            }
          }
          mirror([ 0, 1, 0 ]) {
            mirror([ 1, 0, 0 ]) {
              union() {
                translate([ 0, 7.825, 3.5 ]) {
                  cube([ 17.3, 1.65, 3.25 ], center = true);
                }
                translate([ 7.825, 0, 3.5 ]) {
                  cube([ 1.65, 17.3, 3.25 ], center = true);
                }
              }
            }
          }
        }
    }
  }
  // kailh choc hotswap
  color("Orange", 1) {  
    translate([ 17.3, -51.9, -0.12 ]) {
      union() {
          union() {
            translate([ 0, 7.825, 3.5 ]) {
              cube([ 17.3, 1.65, 3.25 ], center = true);
            }
            translate([ 7.825, 0, 3.5 ]) {
              cube([ 1.65, 17.3, 3.25 ], center = true);
            }
          }
          mirror([ 0, 1, 0 ]) {
            mirror([ 1, 0, 0 ]) {
              union() {
                translate([
                  0,
                  7.825,
                  3.5,
                ]) {
                  cube([ 17.3, 1.65, 3.25 ], center = true);
                }
                translate([ 7.825, 0, 3.5 ]) {
                  cube([ 1.65, 17.3, 3.25 ], center = true);
                }
              }
            }
          }
          union() {
            difference() {
              translate([ 2, 5, 0.2 ]) { cube([ 10, 7, 5.5 ], center = true); }
              translate([ -0.6, 6, 1.2 ]) {
                cube([ 5, 7, 5.5 ], center = true);
              }
              translate([ 5, 4, 1.2 ]) { cube([ 7, 7, 5.5 ], center = true); }
            }
            difference() {
              translate([ 0, 4.25, 1.5 ]) {
                cube([ 17.0, 8.5, 3 ], center = true);
              }
              cylinder($fn = 12, h = 10, r = 2.0, center = true);
              union() {
                translate([ -5, 4, 0 ]) {
                  cylinder($fn = 8, h = 10, r = 1.65, center = true);
                }
                translate([ 5, 4, 5 ]) {
                  cylinder($fn = 8, h = 10, r = 1.65, center = true);
                }
              }
              union() {
                translate([ 0, 6, 5 ]) {
                  cylinder($fn = 8, h = 10, r = 1.65, center = true);
                }
                translate([ 0, 6, 5 ]) {
                  cylinder($fn = 8, h = 10, r = 1.65, center = true);
                }
              }
              translate([ -5.5, 0, 0 ]) {
                cylinder($fn = 8, h = 10, r = 1, center = true);
              }
              translate([ 5.5, 0, 0 ]) {
                cylinder($fn = 8, h = 10, r = 1, center = true);
              }
              translate([ 0, 5, 0.2 ]) {
                cube([ 19, 11.5, 3.5 ], center = true);
              }
            }
          }
        }
    }
  }

}
