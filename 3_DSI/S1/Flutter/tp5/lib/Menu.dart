import 'package:flutter/material.dart';

class MyDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          const DrawerHeader(
            decoration: BoxDecoration(
              color: Colors.blueAccent,
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'Menu',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 35,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                CircleAvatar(
                  radius: 40,
                  backgroundImage: AssetImage('assets/logo.jpg'),
                ),

              ],
            ),
          ),
          ListTile(
            leading: const Icon(Icons.home, color: Colors.blueAccent),
            title: const Text(
              'Home Page',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.w500),
            ),
            onTap: () {
              Navigator.pushNamed(context, '/HomePage');
            },
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.looks_one_rounded, color: Colors.blueAccent),
            title: const Text(
              'Page 1',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.w500),
            ),
            onTap: () {
              Navigator.pushNamed(context, '/Page1');
            },
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.looks_two_rounded, color: Colors.blueAccent),
            title: const Text(
              'Page 2',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.w500),
            ),
            onTap: () {
              Navigator.pushNamed(context, '/Page2');
            },
          ),
        ],
      ),
    );
  }
}
