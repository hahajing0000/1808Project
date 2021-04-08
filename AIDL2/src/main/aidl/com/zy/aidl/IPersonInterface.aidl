// IPersonInterface.aidl
package com.zy.aidl;

// Declare any non-default types here with import statements
import com.zy.aidl.Person;

interface IPersonInterface {
    void addPerson(in Person inPerson,out Person outPerson);
}
