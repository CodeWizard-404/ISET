import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Flutter Demo',
      home: MyHomePage(title: 'Saisie de Données'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final TextEditingController _Controller1 = TextEditingController();
  final _formKey = GlobalKey<FormState>();  // Global key for form state

  @override
  void initState() {
    super.initState();
    _Controller1.addListener(() {
      final tt = _Controller1.text;
      print('text01: ${tt}');
    });
  }

  @override
  void dispose() {
    _Controller1.dispose();
    super.dispose();
  }

  void _Valdiation() {
    if (_formKey.currentState!.validate()) {
      _submit();
    } else {
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: const Text("Error"),
            content: const Text("Please fill out all fields correctly."),
            actions: [
              TextButton(
                onPressed: () => Navigator.of(context).pop(),
                child: const Text("OK"),
              ),
            ],
          );
        },
      );
    }
  }


  void _submit() {
    if (_formKey.currentState?.validate() ?? false) {
      final String value = _Controller1.text;
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: const Text("TextField Submitted"),
            content: Text("Value: $value"),
            actions: [
              TextButton(
                onPressed: () => Navigator.of(context).pop(),
                child: const Text("OK"),
              ),
            ],
          );
        },
      );
    } else {
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: const Text("Error"),
            content: const Text("Please fill out all fields correctly."),
            actions: [
              TextButton(
                onPressed: () => Navigator.of(context).pop(),
                child: const Text("OK"),
              ),
            ],
          );
        },
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextField(
                controller: _Controller1,
                decoration: const InputDecoration(
                  labelText: 'TextField',
                  border: OutlineInputBorder(),
                ),
                onSubmitted: (value) => _submit(),
              ),
              const SizedBox(height: 20),

              TextFormField(
                decoration: const InputDecoration(
                  labelText: 'TextFormField',
                  border: OutlineInputBorder(),
                ),
                //onFieldSubmitted: (value) => _submit(),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter some text';
                  }
                  return null;
                },
              ),
              const SizedBox(height: 20),

              TextFormField(
                obscureText: true,
                decoration: const InputDecoration(
                  labelText: 'Password',
                  border: OutlineInputBorder(),
                ),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter a password';
                  }
                  return null;
                },
              ),
              const SizedBox(height: 20),

              Row(
                children: [
                  ClipRRect(
                    borderRadius: BorderRadius.circular(7),
                    child: Image.asset(
                      'images.jpg',
                      height: 57,
                    ),
                  ),
                  const SizedBox(width: 10),
                  const Expanded(
                    child: TextField(
                      decoration: InputDecoration(
                        labelText: 'Name',
                        border: OutlineInputBorder(),
                      ),
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 20),

              ElevatedButton(
                onPressed: _Valdiation,
                child: const Text("Submit"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
