package com.susieson.food.ui.main.picture

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.susieson.food.R
import com.susieson.food.common.RC_CAMERA
import com.susieson.food.databinding.FragmentPictureBinding
import pub.devrel.easypermissions.EasyPermissions
import timber.log.Timber

class PictureFragment : Fragment(), EasyPermissions.PermissionCallbacks,
    EasyPermissions.RationaleCallbacks {
    private lateinit var binding: FragmentPictureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_picture, container, false)
        showCamera()
        return binding.root
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        when (requestCode) {
            RC_CAMERA -> {
                showCamera()
            }
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        when (requestCode) {
            RC_CAMERA -> {
                if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
                    Timber.d("camera permission permanently denied")
                }
            }
        }
        findNavController().navigateUp()
    }

    override fun onRationaleAccepted(requestCode: Int) {

    }

    override fun onRationaleDenied(requestCode: Int) {
        findNavController().navigateUp()
    }

    private fun showCamera() {
        if (EasyPermissions.hasPermissions(requireContext(), Manifest.permission.CAMERA)) {
            Timber.d("camera permission granted")
        } else {
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.camera_permission_rationale),
                RC_CAMERA,
                Manifest.permission.CAMERA
            )
        }
    }
}