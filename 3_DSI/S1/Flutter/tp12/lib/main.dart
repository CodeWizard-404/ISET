import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: _Form(),
    );
  }
}

class _Form extends StatefulWidget {
  @override
  _FormState createState() => _FormState();
}

class _FormState extends State<_Form> {
  final _formKey = GlobalKey<FormState>();
  String? name;
  String? password;
  String? sexe;

  @override
  void initState() {
    super.initState();
    sexe = 'M';
  }

  void _submitForm() {
    if (_formKey.currentState!.validate()) {
      showDialog(
        context: context,
        builder: (context) {
          return AlertDialog(
            title: const Text('Form Valid'),
            content: Text('Name: $name\nSexe: $sexe\nPassword: $password'),
            actions: [
              TextButton(
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: const Text('Close'),
              ),
            ],
          );
        },
      );
    } else {
      showDialog(
        context: context,
        builder: (context) {
          return AlertDialog(
            title: const Text('Form Invalid'),
            content: const Text('Empty/Wrong Input'),
            actions: [
              TextButton(
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: const Text('OK'),
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
      appBar: AppBar(title: const Text('Form')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                decoration: const InputDecoration(labelText: 'Name'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your name';
                  }
                  return null;
                },
                onChanged: (value) {
                  setState(() {
                    name = value;
                  });
                },
              ),
              Row(
                children: [
                  Radio<String>(
                    value: 'M',
                    groupValue: sexe,
                    onChanged: (value) {
                      setState(() {
                        sexe = value!;
                      });
                    },
                  ),
                  const Text('M'),
                  Radio<String>(
                    value: 'F',
                    groupValue: sexe,
                    onChanged: (value) {
                      setState(() {
                        sexe = value!;
                      });
                    },
                  ),
                  const Text('F'),
                ],
              ),
              TextFormField(
                decoration: const InputDecoration(labelText: 'Password'),
                obscureText: true,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Enter a password';
                  }
                  if (value.length < 8) {
                    return 'Password < 8';
                  }
                  if (value.contains('_')) {
                    return 'Wrong Input "_"';
                  }
                  return null;
                },
                onChanged: (value) {
                  setState(() {
                    password = value;
                  });
                },
              ),
              // Submit button
              ElevatedButton(
                onPressed: _submitForm,
                child: const Text('Submit'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
