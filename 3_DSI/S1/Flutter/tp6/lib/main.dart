import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {

    final List<String> weekdays = [
      'Monday',
      'Tuesday',
      'Wednesday',
      'Thursday',
      'Friday',
      'Saturday',
      'Sunday',
    ];

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Weekdays List'),
        ),
        body: ListView.builder(
          itemCount: weekdays.length,
          itemBuilder: (context, index) {
            return ListTile(title: Text(weekdays[index]));
          },
        ),
      ),
    );
  }
}
