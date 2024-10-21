import 'package:flutter/material.dart';

import '../Menu.dart';

class Page2 extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Page 2'),
        ),
      drawer: MyDrawer(),
      body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [

              const Text(
                'Go Back: ',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.blue),
              ),
              ElevatedButton(
                style: TextButton.styleFrom(
                    foregroundColor: Colors.white,
                    backgroundColor: Colors.blue,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                    shadowColor: Colors.black,
                    elevation: 10,
                    side: const BorderSide(
                      color: Colors.white,
                      width: 3,
                    )
                ),
                onPressed: () {
                  Navigator.of(context).pop();
                }, // foreground
                child: const Text('Back'),
              ),

            ],
          ),
        ),

    );
  }
}
