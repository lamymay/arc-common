package com.arc.core.model.domain.app;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author 叶超
 * @since 2020/2/27 10:46
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class AppContact {

    private static final long serialVersionUID = 1L;

    //本系统中的id是主键
//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //是每个通讯录中的id，不唯一，每个设备上的通讯录id各自独立
    @Deprecated
    private Integer contactId;

    //本系统唯一的用户id
    private Long userId;

    private String displayName;

    private List<String> phones;
    private List<String> emails;

    private String cellphone;
    private String telephone;
    private String email;

    private String im;
    private String photo;
    private String nickname;
    private String organization;
    private String postalAddress;
    private String groupMembership;

    //保留字段
    private String name;
    private Integer state;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public AppContact() {
    }

    public AppContact(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppContact contact = (AppContact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(contactId, contact.contactId) &&
                Objects.equals(userId, contact.userId) &&
                Objects.equals(displayName, contact.displayName) &&
                Objects.equals(cellphone, contact.cellphone) &&
                Objects.equals(telephone, contact.telephone) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(im, contact.im) &&
                Objects.equals(photo, contact.photo) &&
                Objects.equals(nickname, contact.nickname) &&
                Objects.equals(organization, contact.organization) &&
                Objects.equals(postalAddress, contact.postalAddress) &&
                Objects.equals(groupMembership, contact.groupMembership) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(state, contact.state) &&
                Objects.equals(createTime, contact.createTime) &&
                Objects.equals(updateTime, contact.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactId, userId, displayName, cellphone, telephone, email, im, photo, nickname, organization, postalAddress, groupMembership, name, state, createTime, updateTime);
    }

    //
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        AppContact contact = (AppContact) o;
//
//        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
//        if (contactId != null ? !contactId.equals(contact.contactId) : contact.contactId != null) return false;
//        if (userId != null ? !userId.equals(contact.userId) : contact.userId != null) return false;
//        if (displayName != null ? !displayName.equals(contact.displayName) : contact.displayName != null) return false;
//        if (cellphone != null ? !cellphone.equals(contact.cellphone) : contact.cellphone != null) return false;
//        if (telephone != null ? !telephone.equals(contact.telephone) : contact.telephone != null) return false;
//        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
//        if (im != null ? !im.equals(contact.im) : contact.im != null) return false;
//        if (photo != null ? !photo.equals(contact.photo) : contact.photo != null) return false;
//        if (nickname != null ? !nickname.equals(contact.nickname) : contact.nickname != null) return false;
//        if (organization != null ? !organization.equals(contact.organization) : contact.organization != null)
//            return false;
//        if (postalAddress != null ? !postalAddress.equals(contact.postalAddress) : contact.postalAddress != null)
//            return false;
//        if (groupMembership != null ? !groupMembership.equals(contact.groupMembership) : contact.groupMembership != null)
//            return false;
//        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
//        if (state != null ? !state.equals(contact.state) : contact.state != null) return false;
//        if (createTime != null ? !createTime.equals(contact.createTime) : contact.createTime != null) return false;
//        return updateTime != null ? updateTime.equals(contact.updateTime) : contact.updateTime == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
//        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
//        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
//        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (im != null ? im.hashCode() : 0);
//        result = 31 * result + (photo != null ? photo.hashCode() : 0);
//        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
//        result = 31 * result + (organization != null ? organization.hashCode() : 0);
//        result = 31 * result + (postalAddress != null ? postalAddress.hashCode() : 0);
//        result = 31 * result + (groupMembership != null ? groupMembership.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (state != null ? state.hashCode() : 0);
//        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
//        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
//        return result;
//    }

}
