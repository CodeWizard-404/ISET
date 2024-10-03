import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Container(
          width: 90,
        height: 120,
        padding: const EdgeInsets.all(80),
        margin: const EdgeInsets.symmetric(vertical: 260,horizontal: 30),

        alignment: Alignment.center,

        constraints: const BoxConstraints(maxWidth: 10,maxHeight: 15),

        decoration: BoxDecoration(
          gradient:  const LinearGradient(
              begin: Alignment.topRight,
              end: Alignment.bottomLeft,
              colors: [
                Colors.blue,
                Colors.white,]),

          border: Border.all(
              color: Colors.white,
              width: 15),
          borderRadius: BorderRadius.circular(50),
          ),

        foregroundDecoration: ShapeDecoration(
          shape: Border.all(
            color: Colors.black,
            width: 10,
          ) + Border.all(
            color: Colors.white,
            width: 10,
          ) + Border.all(
            color: Colors.blue,
            width: 10,
          ),


        ),


        /*decoration: BoxDecoration(
          border: Border.all(
              color: Colors.white,
              width: 15),

          color: const Color.fromARGB(255, 15, 25, 250),
          borderRadius: BorderRadius.circular(50),
          shape: BoxShape.rectangle
        ),*/

          child: const Text("Bonjour DSI31 G1",
              style: TextStyle(fontSize: 35,
                color: Colors.white, // Change text color to black (or any other color)
                decoration: TextDecoration.none,),
          ),
    ),
    );

}
}