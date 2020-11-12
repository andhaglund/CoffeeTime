const functions = require('firebase-functions');

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//   functions.logger.info("Hello logs!", {structuredData: true});
//   response.send("Hello from Firebase!");
// });

// The Firebase Admin SDK to access Cloud Firestore.
const admin = require('firebase-admin');
admin.initializeApp();


// Take the text parameter passed to this HTTP endpoint and insert it into
// Cloud Firestore under the path /messages/:documentId/original
exports.addMessage = functions.https.onRequest(async (req, res) => {
  // Grab the text parameter.
  const original = req.query.text;
  // Push the new message into Cloud Firestore using the Firebase Admin SDK.
  const writeResult = await admin.firestore().collection('messages').add({original: original});
  // Send back a message that we've succesfully written the message
  res.json({result: `Message with ID: ${writeResult.id} added.`});
});

// Listens for new messages added to /messages/:documentId/original and creates an
// uppercase version of the message to /messages/:documentId/uppercase
exports.makeUppercase = functions.firestore.document('/messages/{documentId}')
    .onCreate((snap, context) => {
      // Grab the current value of what was written to Cloud Firestore.
      const original = snap.data().original;

      // Access the parameter `{documentId}` with `context.params`
      functions.logger.log('Uppercasing', context.params.documentId, original);

      const uppercase = original.toUpperCase();

      // You must return a Promise when performing asynchronous tasks inside a Functions such as
      // writing to Cloud Firestore.
      // Setting an 'uppercase' field in Cloud Firestore document returns a Promise.
      return snap.ref.set({uppercase}, {merge: true});
    });


exports.addCompany = functions.https.onRequest(async (req, res) => {
  const {name, code} = req.query;
  console.log("Company: ", name)
  console.log("Code: ", code)

  functions.firestore.document('/messages/')

  // Push the new message into Cloud Firestore using the Firebase Admin SDK.
  const writeResult = await admin.firestore().collection('companies').add({name, code});

  // Send back a message that we've succesfully written the message
  res.json({result: `Message with ID: ${writeResult.id} added.`});
});

exports.addUser = functions.https.onRequest(async (req, res) => {
  const {firstName, lastName, phoneNumber, company, code} = req.query;
  console.log("FirstName: ", firstName)
  console.log("LastName: ", lastName)
  console.log("PhoneNumber: ", phoneNumber)
  console.log("Company: ", company)
  console.log("Code: ", code)

  // Push the new message into Cloud Firestore using the Firebase Admin SDK.
  const writeResult = await admin.firestore().collection('users').add({firstName, lastName, phoneNumber, company});

  // Send back a message that we've succesfully written the message
  res.json({result: `Message with ID: ${writeResult.id} added.`});
});

exports.getUser = functions.https.onRequest(async (req, res) => {

    const firstName = 'Andreas';
    const lastName = 'Haglund';

    const result = await admin.firestore().collection('users').where("phoneNumber", "=", "91808492")
    console.log(result)

});

//exports.getUser = functions.https.onRequest(async (req, res) => {
//
//    const snapshot = await admin.firestore().collection('users').get()
//    return snapshot.docs.map(doc => doc.data());
//
//});
//    const db = admin.firestore();
//
//    db.collection('users').where()
//        .then(doc => {
//        console.log("Inside")
//        console.log(doc.docs);
//           if (!doc.exists) {
//             console.log('No such document!');
//             return res.send('Not Found')
//           }
//             console.log(doc.data());
//             return res.send(doc.data());
//         })
//         .catch(err => {
//           console.log('Error getting document', err);
//         });
//    users.forEach(user => {
//
//    })
//});