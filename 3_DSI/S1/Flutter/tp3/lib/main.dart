import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(

        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Row(
                  children: [
                    SizedBox(width: 10),
                    Icon(
                      Icons.school,
                      color: Colors.blue,
                      size: 60,
                    ),
                    SizedBox(width: 10),
                    Text(
                      'ISET Charguia',
                      style: TextStyle(fontSize: 50),
                    ),
                  ],
                ),



              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Container(
                    padding: const EdgeInsets.all(12),
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                    ),
                    child: const Text('Dep Info', style: TextStyle(fontSize: 16)),
                  ),
                  const SizedBox(width: 20),
                  Container(
                    padding: const EdgeInsets.all(12),
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                    ),
                    child: const Text('Dep Gestion', style: TextStyle(fontSize: 16)),
                  ),
                ],
              ),
              const SizedBox(height: 50),
              const Text(
                'Section Informatique',
                style: TextStyle(fontSize: 30)
              ),

              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.black),
                ),
                child: const Text('DSI', style: TextStyle(fontSize: 16)),
              ),
              const SizedBox(height: 10),
              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.black),
                ),
                child: const Text('RSI', style: TextStyle(fontSize: 16)),
              ),
              const SizedBox(height: 10),
              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.black),
                ),
                child: const Text('SEMm', style: TextStyle(fontSize: 16)),
              ),
              const SizedBox(height: 10),
              Image.asset('assets/images/Log_Iset1.png'),
            ],
          ),
        ),
      ),
    );
  }
}
