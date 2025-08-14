package Code.SolidPrinciple;

import java.util.ArrayList;
import java.util.List;



/**
 * S:Single responsoibility function
 * O:open for extension close for modification
 * L:Liskov's substitution principle
 * I:interface should be such that it doesn't need to implement unnecessary function
 * D:Dependency inversion principle
 *
 * here in this file , we 're chcking why Liskov substitution principle is import and how it works
 * Liskov's inversion principle says that if class B is subclass of class A then we should be able to replace an object of A with object of B without breaking the functionality
 *
 *
 * */



    public class Main{




        public static void main(String args[]){
            List<Vehicle> vehicleList = new ArrayList<>();
            vehicleList.add(new MotorCycle());
            vehicleList.add(new Car());
            vehicleList.add(new BiCycle());
            for(Vehicle v : vehicleList){
//                System.out.println(v.hasEngine().toString());
            }
        }






        public static class Vehicle {
            public Integer getNumberOfWheels(){
                return 2;
            }
        }

        public static class MotorCycle extends Vehicle {

        }

        public static class EngineVehicle extends Vehicle{
            public Boolean hasEngine(){
                return true;
            }

        }
        public static class Car extends EngineVehicle {

            @Override
            public Integer getNumberOfWheels(){
                return 4;
            }

        }
        public static class BiCycle extends  Vehicle{
            public Boolean hasEngine(){
                return null;
            }
        }
    }

