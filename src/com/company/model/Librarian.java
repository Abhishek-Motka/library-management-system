package com.company.model;

import com.company.enums.AccountStatus;

import java.util.List;

public class Librarian extends Person
{
    public Librarian(String name, ContactInfo contactInfo)
    {
        super(name, contactInfo);
    }

    public void addBookItems(List<BookItem> bookItems) {
        BookRepository.getInstance().addBookItems(bookItems);
    }

    public void blockMember(String memberId) {
        Member member = UserRepository.getInstance().getMember(memberId);
        member.setAccountStatus(AccountStatus.BLOCKED);
    }

    public void unblockMember(String memberId) {
        Member member = UserRepository.getInstance().getMember(memberId);
        member.setAccountStatus(AccountStatus.ACTIVE);
    }

    public String addMember(String name, String emailAddress, String phoneNumber, String address) {
        ContactInfo contactInfo = new ContactInfo(emailAddress, phoneNumber, address);
        Member member = new Member(name, contactInfo);
        UserRepository.getInstance().addMember(member);
        return member.getId();
    }

    public Member removeMember(String memberId) {
        return UserRepository.getInstance().removeMember(memberId);
    }
}
