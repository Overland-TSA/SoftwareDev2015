/*
 * This is a JavaScript Scratchpad.
 *
 * Enter some JavaScript, then Right Click or choose from the Execute Menu:
 * 1. Run to evaluate the selected text (Ctrl+R),
 * 2. Inspect to bring up an Object Inspector on the result (Ctrl+I), or,
 * 3. Display to insert the result in a comment after the selection. (Ctrl+L)
 */

// Department  -------------------------------------------------
function Department(name) {
  this.name = name;
  this.coordinator = undefined;
  this.faculty = [];
}

Department.prototype.setCoordinator = function(head) {
  this.coordinator = head;
}

Department.prototype.addStaff = function(staff) {
  this.faculty.push(staff);
}

Department.prototype.toString = function() {
  s = "strings_" + this.name.toLowerCase() +".xml";
  s += "\n"
  
  for (var i=0; i<this.faculty.length; i++) {
    s += "\n";
    s += this.faculty[i].toString();
  }
  
  s += "\n\n\n";
  
  return s;
}

// Person  ----------------------------------------------------
function Person(name, telephone, email, department, iscoordinator) {
  this.name = name;
  this.telephone = telephone;
  this.email = email;
  this.department = department;
  this.coordinator = iscoordinator;
}

Person.prototype.isCoordinator = function() {
  return this.coordinator;
};

Person.prototype.toString = function() {
  name_string  = '<string name="' + this.name.split(" ")[1].toLowerCase() + '_name">' + this.name + '</string>';
  phone_string = '<string name="' + this.name.split(" ")[1].toLowerCase() + '_phone">' + this.telephone + '</string>';
  email_string = '<string name="' + this.name.split(" ")[1].toLowerCase() + '_email">' + this.email + '</string>';
  return [name_string, phone_string, email_string].join("\n");
};


// main  ------------------------------------------------------
function main(depname) {
  
  // find the HTML elements we'll have to deal with
  table = document.querySelector("table");
  tbody = table.tBodies[0];
  
  // the data we want
  rows = tbody.children;
  dep = new Department(depname);
  
  for (var i=1; i<rows.length; i++) {
    contact = rows[i]
    contactStrings = contact.textContent.split("\n");
    
    staff = new Person(
      contactStrings[0].split(", coordinator")[0],
      contactStrings[1],
      contactStrings[2],
      dep.name,
      contactStrings[0].indexOf("coordinator") > -1
    );
    
    dep.addStaff( staff );
    
    if (staff.isCoordinator()) {
      dep.setCoordinator(staff);
    }
  } // done looping per contact
  
  return dep;
}

d = main(prompt("Department"));
console.log(d.toString());

/*
Exception: this.name is null
Department.prototype.toString@Scratchpad/1:26:3
@Scratchpad/1:94:1
*/