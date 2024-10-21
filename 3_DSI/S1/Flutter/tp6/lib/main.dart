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
        appBar: AppBar(
            title: const Text('Weekdays List')
        ),
        body: ListView(
          children: [
            ListTile(
              title: const Text('Monday'),
              onTap: () {
                print('Day');
              },
            ),
            const ListTile(title: Text('Tuesday')),
            const ListTile(title: Text('Wednesday')),
            const ListTile(title: Text('Thursday')),
            const ListTile(title: Text('Friday')),
            const ListTile(title: Text('Saturday')),
            const ListTile(title: Text('Sunday')),
          ],
        ),
      ),
    );
  }
}
