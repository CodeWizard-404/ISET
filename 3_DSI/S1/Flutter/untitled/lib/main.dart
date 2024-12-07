import 'package:flutter/material.dart';
import 'Page2.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Exam ',
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final _formKey = GlobalKey<FormState>();
  final _dsController = TextEditingController();
  final _examController = TextEditingController();

  @override
  void dispose() {
    _dsController.dispose();
    _examController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Page 1'),
        centerTitle: true,
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Form(
            key: _formKey,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                TextFormField(

                  controller: _dsController,
                  decoration: const InputDecoration(labelText: 'Note DS'),
                  keyboardType: TextInputType.number,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter a value';
                    }
                    return null;
                  },
                ),
                const SizedBox(height: 10),
                TextFormField(
                  controller: _examController,
                  decoration: const InputDecoration(labelText: 'Note Exam'),
                  keyboardType: TextInputType.number,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter a value';
                    }
                    return null;
                  },
                ),
                const SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () {
                    if (_formKey.currentState!.validate()) {
                      final dsScore = double.parse(_dsController.text);
                      final examScore = double.parse(_examController.text);
                      final average = dsScore * 0.3 + examScore * 0.7;

                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => PageTwo(average: average),
                        ),
                      );
                    }
                  },
                  child: const Text('Calculate Moyenne'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}